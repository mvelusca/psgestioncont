<!-- Ce compose affiche la barre latérale contenant le principales parties de navigation
    il est composé de :
      Bouton "tableau de bord"
      Bouton "conteneurs"
      Bouton "administration"-->

<template>
    <v-navigation-drawer app :expand-on-hover="expandOnHover" :right="$vuetify.rtl" color="#084772" theme="dark" v-model="drawer" v-bind="$attrs">
      <v-list>
        <!-- item pour le tableau de bord -->
          <v-list-item prepend-icon="mdi-view-dashboard" title="Tableau de bord" value="Dashboard"></v-list-item>
        <!-- liste groupée de bouton contenu dans le bouton conteneur -->
          <v-list v-model="open">
            <v-list-group  value="Conteneurs" >
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
                :key="item.name"
                :value="item.name"
                :title="item.name"
                prepend-icon="mdi-file-outline"
                @click="setContainerSelected(!$store.state.containerSelected)"
                min-width="400"
                style="margin-left: -40%;"
              ></v-list-item>
            </v-list-group>

            <v-list-group value="Alfresco">
              <template v-slot:activator="{ props }">
                <v-list-item v-bind="props" title="Alfresco"></v-list-item>
              </template>

              <v-list-item
                v-for="item in $store.state.listAlfresco"
                :key="item.name"
                :value="item.name"
                :title="item.name"
                prepend-icon="mdi-file-outline"
                @click="setContainerSelected(!$store.state.containerSelected)"
                min-width="400"
                style="margin-left: -40%;"
              ></v-list-item>
            </v-list-group>


            <v-list-group value="Nuxeo" >
              <template v-slot:activator="{ props }">
                <v-list-item v-bind="props" title="Nuxeo"></v-list-item>
              </template>

              <v-list-item
                v-for="item in $store.state.listNuxeo"
                :key="item.name"
                :value="item.name"
                :title="item.name"
                prepend-icon="mdi-file-outline"
                @click="setContainerSelected(!$store.state.containerSelected)"
                min-width="400"
                style="margin-left: -40%;"
              ></v-list-item>
            </v-list-group>


            <v-list-group value="FileNet">
              <template v-slot:activator="{ props }">
                <v-list-item v-bind="props" title="FileNet"></v-list-item>
              </template>

              <v-list-item
                v-for="item in $store.state.listFileNet"
                :key="item.name"
                :value="item.name"
                :title="item.name"
                prepend-icon="mdi-file-outline"
                @click="setContainerSelected(!$store.state.containerSelected)"
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
import { mapState, mapMutations, mapGetters } from 'vuex'

export default {
  name:"SideBarComponent",

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
  }),



  computed: {
    ...mapState(['containerSelected']),
    ...mapState(['listAlfresco']),
    ...mapState(['listFileNet']),
    ...mapState(['listNuxeo']),

    ...mapGetters(['getContainer']),
    ...mapGetters(['getListe']),

    listGlobal() {
      return this.listAlfresco.concat(this.listFileNet, this.listNuxeo) ;
    },


    drawer: {
      get () {
       return this.$store.state.drawer
      },

      set (val) {
        this.$store.commit('SET_DRAWER', val)
      },

    },
  },
  methods: {
    ...mapMutations({
      setContainerSelected: 'SET_CONTAINER_SELECTED',
    }),

  },

}
</script>

<style>

</style>
