<template>
  <v-footer class="bg-blue-lighten-1">
    <v-row justify="center" no-gutters>
      <v-btn
        v-for="link in links"
        :key="link"
        color="white"
        variant="text"
        class="mx-2"
        rounded="xl"
      >
        {{ link }}
      </v-btn>
      <v-col class="text-center mt-4" cols="12">
        {{ new Date().getFullYear() }} — <strong>Amexio</strong>
        <v-btn
        v-for="icon in icons"
        :key="icon"
        class="mx-4"
        :icon="icon"
        variant="text"
      ></v-btn>
      </v-col>
    </v-row>
  </v-footer>
</template>

<script>
export default {

  name: "FooterComponent",

  data: () => ({
    links: [
      'Home',
      'About Us',
      'Team',
      'Services',
      'Contact Us',
    ],

    icons: [
      'mdi-facebook',
      'mdi-twitter',
      'mdi-linkedin',
      'mdi-instagram',
    ],
  }),

}
</script>

<style>

</style>
