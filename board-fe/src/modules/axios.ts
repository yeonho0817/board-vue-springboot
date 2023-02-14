import Axios, { AxiosInstance, AxiosRequestConfig, AxiosResponse } from 'axios';
import { Notify } from 'quasar';

export interface HttpResponse<T = unknown> {
	data: T;
	code: string;
	status: string;
	message?: string;
}

interface Notification {
	caption: string;
	type: string;
	icon: string;
	classes: string;
	timeout: number;
	message?: string;
}


const TIMEOUT = 10000;

const api: AxiosInstance = Axios.create({
	baseURL: 'http://localhost:8080',
	headers: {
		'Access-Control-Allow-Origin': '*',
	},
	timeout: TIMEOUT,
});

api.interceptors.response.use(
	(response: AxiosResponse<HttpResponse>) => {
		if (response.data) {
            status(response);
			return response;
		}
		
		return Promise.reject(response);
	},
	async (error) => {
		const response = error.response;
        status(response);
		return Promise.reject(response);
	}
);

const status = (response: AxiosResponse) => {
	const errorNotify: Notification = {
		caption: response?.data?.message,
		type: 'negative',
		icon: 'warning',
		classes: 'app-notify',
		timeout: 500,
	};

    const successNotify: Notification = {
		caption: response?.data?.message,
		type: 'positive',
		icon: 'info',
		classes: 'app-notify',
		timeout: 500,
	};
    

    if (response?.status >= 400) {
        Notify.create(errorNotify);
    } else {
        Notify.create(successNotify);
    }

};

export default api;