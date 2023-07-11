<template>
  <div>
  <AppBarComponent/>
  <SideBarComponent valueEnfant="valueParent"/>
  <ListeContainers valueEnfant="valueParent"/>
</div>
</template>

<script>
import { defineComponent } from "vue";

// Components
import AppBarComponent from "@/components/AppBarComponent.vue";
import SideBarComponent from "@/components/SideBarComponent.vue";
import ListeContainers from "@/components/ListeContainers.vue";

export default defineComponent({
  name: "ContainersPage",
  
  components: {
    AppBarComponent,
    SideBarComponent,
    ListeContainers,
},

});
</script>
