<template>
    <RegistrationComponent/>
  </template>

<script>
  import { defineComponent } from "vue";
  
  // Components
  import RegistrationComponent from "@/components/RegistrationComponent.vue";

  
  export default defineComponent({
    name: "ConnexionPage",
  
    components: {
    RegistrationComponent,
},
  });
  </script>
