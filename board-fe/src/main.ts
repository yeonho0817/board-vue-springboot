import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { Quasar } from "quasar";
import "@quasar/extras/material-icons/material-icons.css";
import "quasar/src/css/index.sass";

import "@/styles/index.scss";

const app = createApp(App);

app.use(Quasar, {
    plugins: {},
  });

app
.use(router)
.mount('#app')
