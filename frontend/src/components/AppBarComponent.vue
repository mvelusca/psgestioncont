<!-- Ce composant gère la barre de navigation (navbar).
Il est composé:
              - D'un bouton hamburger (ici $menu) qui affiche la barre latérale (sidebar).
              - D'une clôche de notification (mdi-bell-outline) affichant les notifs reçues
              - D'un bouton de profil donnant accès à la page de profile-->
<template>
    <v-app-bar absolute app :elevation="6" color="#084772">
      <template v-slot:prepend>
        <v-btn  icon="$menu" color="white" @click="setDrawer(!drawer)"></v-btn>
      </template>
      <div class="text-left">
        <v-menu transition="scale-transition">
          <template v-slot:activator="{ props }">
          <v-btn class="text-none" stacked>
            <v-badge :content="items.length" color="error" >
              <v-icon color="white" size="30" v-bind="props">mdi-bell-outline</v-icon>
            </v-badge>
          </v-btn>
        </template>
          <v-list>
            <v-list-item
              v-for="(item, i) in items"
              :key="i"
            >
              <v-list-item-title>{{ item.title }}</v-list-item-title>
            </v-list-item>
          </v-list>

        </v-menu>


        <v-menu
          min-width="200px"
          rounded
        >
        <template v-slot:activator="{ props }">
          <v-btn
            icon
            v-bind="props"
            class="text-none" stacked
          >
            <v-avatar
              color="black"
              size="large"
            >
              <span class="text-h5">{{ user.initials }}</span>
            </v-avatar>
          </v-btn>
        </template>
        <v-card>
          <v-card-text>
            <div class="mx-auto text-center">
              <v-avatar
                color="black"
              >
                <span class="text-h5">{{ user.initials }}</span>
              </v-avatar>
              <h3>{{ user.fullName }}</h3>
              <p class="text-caption mt-1">
                {{ user.email }}
              </p>
              <v-divider class="my-3"></v-divider>
              <v-btn
                rounded
                variant="text"
              >
                Modifier son profil
              </v-btn>
              <v-divider class="my-3"></v-divider>
              <v-btn
                rounded
                variant="text"
                to="/"
              >
                Se déconnecter
              </v-btn>
            </div>
          </v-card-text>
        </v-card>
      </v-menu>

      </div>
    </v-app-bar>
</template>

<script>
import { mapState, mapMutations } from 'vuex'
export default {
  name: "AppBarComponent",

  props: {
    value: {
      type: Boolean,
      default: false,
    },
  },

  data: () => ({
      items: [
        { title: 'Valider un nouvel utilisateur' },
        { title: 'Notification 2' },
        { title: 'Notification 3' },
        { title: 'Notification 4' },
        { title: 'Notification 5' },
      ],
      user: {
        initials: 'JD',
        fullName: 'John Doe',
        email: 'john.doe@amexio.com',
      },
  }),

  computed: {
    ...mapState(['drawer']),
  },
  methods: {
    ...mapMutations({
      setDrawer: 'SET_DRAWER',
    }),
  },

}
</script>

<style>

</style>
