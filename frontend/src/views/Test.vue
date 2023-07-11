<template>
  <div>
  <AppBarComponent/>
  <SideBarComponent/> 
    <TestBoard/>
  </div>
  </template>

<script>
  import { defineComponent } from "vue";
  
  // Components
  import AppBarComponent from "@/components/AppBarComponent.vue";
  import SideBarComponent from "@/components/SideBarComponent.vue";

  import TestBoard from "@/components/TestBoard.vue";

  
  export default defineComponent({
    name: "TestPage",
  
    components: {
    AppBarComponent,
    SideBarComponent,
    TestBoard,

},
  });
  </script>
