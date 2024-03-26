import { createApp } from 'vue'
import App from './App.vue'

// 임포트 순서 중요
// npm install vue bootstrap-vue-3
import { BootstrapVue3 } from 'bootstrap-vue-3'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue-3/dist/bootstrap-vue-3.css'

// createApp(App).mount('#app')
const app = createApp(App)
app.use(BootstrapVue3)
app.mount('#app')