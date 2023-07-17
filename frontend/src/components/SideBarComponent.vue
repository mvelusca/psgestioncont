<!-- Ce compose affiche la barre latérale contenant le principales parties de navigation
    il est composé de :
      Bouton "tableau de bord"
      Bouton "conteneurs"
      Bouton "administration"-->

<template>
  <!-- <ListeContainer :message=containerName /> -->
  <v-navigation-drawer ref="sidebar" app :expand-on-hover="expandOnHover" :right="$vuetify.rtl" color="#084772" theme="dark" v-model="drawer" v-bind="$attrs">
    <input ref="input">
    <v-list>
      <v-list-item prepend-icon="mdi-view-dashboard" title="Tableau de bord" value="Dashboard"></v-list-item>
      <v-list v-model="open">

        <v-list-group value="Conteneurs">
          <template v-slot:activator="{ props }">
            <v-list-item
              prepend-icon="mdi-file-outline"
              v-bind="props"
              title="Conteneurs"
            ></v-list-item>
          </template>

          <v-list-group value="Global">
            <template v-slot:activator="{ props }">
              <v-list-item v-bind="props" title="Global"></v-list-item>
            </template>

            <v-list-item
              v-for="item in listGlobal"
              :key="item"
              :value="item"
              :title="item.name"
              prepend-icon="mdi-file-outline"
              @click="setContainerSelected(item)"
              min-width="400"
              style="margin-left: -40%;"
            ></v-list-item>
          </v-list-group>

          <v-list-group value="Alfresco">
            <template v-slot:activator="{ props }">
              <v-list-item v-bind="props" title="Alfresco"></v-list-item>
            </template>

            <v-list-item
              v-for="item in listAlfresco"
              :key="item"
              :value="item"
              :title="item.name"
              prepend-icon="mdi-file-outline"
              @click="setContainerSelected(item)"
              min-width="400"
              style="margin-left: -40%;"
            ></v-list-item>
          </v-list-group>

          <v-list-group value="Nuxeo">
            <template v-slot:activator="{ props }">
              <v-list-item v-bind="props" title="Nuxeo"></v-list-item>
            </template>

            <v-list-item
              v-for="item in listNuxeo"
              :key="item"
              :value="item"
              :title="item.name"
              prepend-icon="mdi-file-outline"
              @click="setContainerSelected(item)"
              min-width="400"
              style="margin-left: -40%;"
            ></v-list-item>
          </v-list-group>

          <v-list-group value="FileNet">
            <template v-slot:activator="{ props }">
              <v-list-item v-bind="props" title="FileNet"></v-list-item>
            </template>

            <v-list-item
              v-for="item in listFileNet"
              :key="item"
              :value="item"
              :title="item.name"
              prepend-icon="mdi-file-outline"
              @click="setContainerSelected(item)"
              min-width="400"
              style="margin-left: -40%;"
            ></v-list-item>
          </v-list-group>
        </v-list-group>
      </v-list>
          <!-- item pour l'administration -->

          <v-list v-model="open">
              <v-list-group value="Admin">
              <template v-slot:activator="{ props }">
                <v-list-item
                  v-bind="props"
                  prepend-icon="mdi mdi-application-cog-outline"
                  title="Administration"

                ></v-list-item>
              </template>
              <v-list-item
                v-for="([title, icon], i) in admins"
                :key="i"
                :title="title"
                :prepend-icon="icon"
                :value="title"
                min-width="400"
                style="margin-left: -20%;"
              ></v-list-item>
        </v-list-group>
      </v-list>
    </v-list>
  </v-navigation-drawer>
</template>

<script>
import { mapState, mapMutations, mapGetters } from 'vuex';

export default {


  props: {
    expandOnHover: {
      type: Boolean,
      default: false,
    },
  },

  data: () => ({

      open: ['Conteneurs'],
      admins: [
        ['Gestion des utilisateurs', 'mdi-account-multiple-outline'],
        ['Gestion des conteneurs', 'mdi mdi-database-cog-outline'],
      ],
      //message: containerName,

  }),

  computed: {
    ...mapState(['listAlfresco']),
    ...mapState(['listFileNet']),
    ...mapState(['listNuxeo']),
    ...mapState(['containerSelected']),

    ...mapGetters(['getContainer']),
    ...mapGetters(['getListe']),
    ... mapGetters(['listGlobal']),


    ...mapMutations(['SET_DRAWER']),

    //...mapActions(['selectContainer']),

    drawer: {
      get() {
        return this.$store.state.drawer;
      },
      set(val) {
        this.$store.commit('SET_DRAWER', val);
      },
    },
  },

  methods: {
    ...mapMutations(['SET_CONTAINER_SELECTED']),
    ...mapMutations(['SET_CONTAINER_NAME']),

    setContainerSelected(item) {
      //console.error(item);
      //const containerName = item;
      this.$store.commit('SET_CONTAINER_SELECTED', item);

      //this.$store.commit('SET_DRAWER', false);
      //containerSelected = containerName;
      //console.error(containerSelected);
      //console.error(containerName);
    },
  },
};
</script>

<style></style>
