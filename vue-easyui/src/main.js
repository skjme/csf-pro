import Vue from 'vue'
import 'vx-easyui/dist/themes/default/easyui.css'
import 'vx-easyui/dist/themes/icon.css'
import 'vx-easyui/dist/themes/vue.css'
import EasyUI from 'vx-easyui'
import App from './App.vue'

Vue.use(EasyUI)

// Vue.config.productionTip = false

new Vue({
  EasyUI,
  render: h => h(App)
}).$mount('#app')
