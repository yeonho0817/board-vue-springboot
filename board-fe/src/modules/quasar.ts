// Import Quasar css
import 'quasar/src/css/index.sass';
import '@quasar/extras/roboto-font/roboto-font.css';
import '@quasar/extras/material-icons/material-icons.css';
import '@/styles/index.scss';

import { Dialog, Loading, LoadingBar, Notify, QSpinnerTail, Quasar } from 'quasar';
import langKr from 'quasar/lang/ko-KR';

export const install = (app: any) => {
	app.use(Quasar, {
		config: {
			loadingBar: {
				/* look at QuasarConfOptions from the API card */
				color: 'primary',
				hijackFilter(url: string) {
					// http or https :// any url /api
					return /\/api\/\w*/.test(url);
				},
			},
			loading: {
				spinner: QSpinnerTail,
			},
			notify: {
				position: 'top-right',
				textColor: 'white',
				timeout: 3000,
			},
		},
		plugins: {
			LoadingBar,
			Loading,
			Notify,
			Dialog,
		},
		lang: langKr,
	});
};
