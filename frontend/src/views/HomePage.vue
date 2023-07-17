<template>
  <v-app>
    <AppBarComponent />
    <SideBarComponent />
    <ContainerManagementComponent></ContainerManagementComponent>
    <footer-component></footer-component>
  </v-app>
</template>
<script>
import { defineComponent } from "vue";

// Components
import AppBarComponent from "@/components/AppBarComponent.vue";
import SideBarComponent from "@/components/SideBarComponent.vue";
import FooterComponent from "../components/FooterComponent.vue";
import ContainerManagementComponent from "@/components/ContainerManagementComponent.vue";


export default defineComponent({
  name: "HomePage",

  props:{

  },

  components: {
    AppBarComponent,
    SideBarComponent,
    FooterComponent,
    ContainerManagementComponent
},


  data:() => ({

     expandOnHover: false,
  }),

});
</script>
