<template>
  <v-app>
    <AppBarComponent />
    <SideBarComponent />
    <v-main>
    <user-management-component/>
    </v-main>
    <footer-component></footer-component>
  </v-app>
</template>
<script>
import { defineComponent } from "vue";

// Components
import AppBarComponent from "@/components/AppBarComponent.vue";
import SideBarComponent from "@/components/SideBarComponent.vue";
import UserManagementComponent from "@/components/UserManagementComponent.vue";
import FooterComponent from "../components/FooterComponent.vue";


export default defineComponent({
  name: "HomePage",

  props:{

  },

  components: {
    AppBarComponent,
    SideBarComponent,
    UserManagementComponent,
    FooterComponent,

  },


  data:() => ({

     expandOnHover: false,
  }),

});
</script>
