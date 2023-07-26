import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import createStore from './store';
import './axios'
// Vuetify
import "vuetify/styles";
import { createVuetify } from "vuetify";
import * as components from "vuetify/components";
import * as directives from "vuetify/directives";


const vuetify = createVuetify({
  components,
  directives,
});

createApp(App).use(createStore).use(router).use(vuetify).mount("#app");
