<template>

    <v-list >
        <v-list v-model="open">


      <v-list-group value="Conteneurs">
        <template v-slot:activator="{ props }">
          <v-list-item
            v-bind="props"
            prepend-icon="mdi-account-circle"
            title="Conteneurs"
          ></v-list-item>
        </template>

        <v-list-group value="Global">
          <template v-slot:activator="{ props }">
            <v-list-item v-bind="props" title="Global"></v-list-item>
          </template>

          <v-list-item
            v-for="item in listGlobal"
            :key="item.name"
            :value="item.name"
            :title="item.name"
            prepend-icon="mdi-file-outline"
          ></v-list-item>
        </v-list-group>


        <v-list-group value="Alfresco">
          <template v-slot:activator="{ props }">
            <v-list-item v-bind="props" title="Alfresco"></v-list-item>
          </template>

          <v-list-item
            v-for="item in listAlfresco"
            :key="item.name"
            :value="item.name"
            :title="item.name"
            prepend-icon="mdi-file-outline"
          ></v-list-item>
        </v-list-group>


        <v-list-group value="Nuxeo" >
          <template v-slot:activator="{ props }">
            <v-list-item v-bind="props" title="Nuxeo"></v-list-item>
          </template>

          <v-list-item
            v-for="item in listNuxeo"
            :key="item.name"
            :value="item.name"
            :title="item.name"
            prepend-icon="mdi-file-outline"
          ></v-list-item>
        </v-list-group>


        <v-list-group value="FileNet">
          <template v-slot:activator="{ props }">
            <v-list-item v-bind="props" title="FileNet"></v-list-item>
          </template>

          <v-list-item
            v-for="item in listFileNet"
            :key="item.name"
            :value="item.name"
            :title="item.name"
            prepend-icon="mdi-file-outline"
          ></v-list-item>
        </v-list-group>

      </v-list-group>
    </v-list>
    </v-list>

</template>



<script>
  export default {
    data: () => ({
      open: ['Conteneurs'],
      listGlobal: [],
      listAlfresco: [
      {
        name: "Contenair Alfresco 1",
        createur: "pierre",
        cpu: "55",
        ram: "44",
        date: "22/11/23",
        etat: "Actif",
      },
      {
        name: "Contenair Alfresco 2",
        createur: "pierre",
        cpu: "55",
        ram: "44",
        date: "22/11/23",
        etat: "Actif"
      },
    ],
    listFileNet: [
      {
        name: "Contenair FileNet 1",
        createur: "pierre",
        cpu: "55",
        ram: "44",
        date: "22/11/23",
        etat: "Actif"
      },
      {
        name: "Contenair FileNet 2",
        createur: "pierre",
        cpu: "55",
        ram: "44",
        date: "22/11/23",
        etat: "Actif"
      },
    ],
      listNuxeo: [
      {
        name: "Contenair Nuxeo 1",
        createur: "pierre",
        cpu: "55",
        ram: "44",
        date: "22/11/23",
        etat: "Actif"
      },
      {
        name: "Contenair Nuxeo 2",
        createur: "pierre",
        cpu: "55",
        ram: "44",
        date: "22/11/23",
        etat: "Actif"
      },
    ],
    }),
    created() {
      this.listGlobal = this.listGlobal.concat(
      this.listAlfresco,
      this.listFileNet,
      this.listNuxeo
    );
  }
  }
</script>
