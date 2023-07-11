<template>
  <v-app>
    <div class="background"></div>
    <v-main class="d-flex justify-center align-center">
      <v-col cols="10" lg="4" class="mx-auto">
        <v-card class="pa-4">
          <div class="text-center">
            <!-- <v-img
            style="background-position: center;"
            :width="241"
            aspect-ratio="16/9"
            src="../assets/amexiologo.png"></v-img> -->

            <v-avatar size="100" color="indigo lighten-4">
              <v-icon size="40" color="white">mdi-account</v-icon>
            </v-avatar>
          </div>
          <v-form @submit.prevent="submitHandler" ref="form">
            <v-card-text>
              <v-text-field
                v-model="email"
                :rules="emailRules"
                type="email"
                label="Email"
                placeholder="Email"
                prepend-inner-icon="mdi-account"
                required
              />
              <v-text-field
                v-model="password"
                :rules="passwordRules"
                :type="passwordShow ? 'text' : 'password'"
                label="Password"
                placeholder="Password"
                prepend-inner-icon="mdi-key"
                :append-icon="passwordShow ? 'mdi-eye' : 'mdi-eye-off'"
                @click:append="passwordShow = !passwordShow"
                required
              />
              <v-switch label="Se souvenir de moi" color="indigo"></v-switch>
            </v-card-text>
            <v-card-actions class="justify-center">
              <v-btn :loading="loading" type="submit" color="primary">
              <span class="white--text px-8">Connexion</span>
              </v-btn>
                <v-spacer></v-spacer> <!-- Ajout d'un espaceur pour séparer les boutons -->
              <v-btn color="primary" @click="register"> <!-- Bouton "S'inscrire" -->
              <span class="white--text px-8">S'inscrire ?</span>
              </v-btn>
            </v-card-actions>
          </v-form>
        </v-card>
      </v-col>
    </v-main>
  </v-app>
</template>

<script>
import axios from "axios"

export default {
  name: "LoginComponent",
  data: () => ({
    loading: false,
    snackbar: false,
    passwordShow: false,
    email: "",
    emailRules: [
      (v) => !!v || "E-mail est obligatoire",
      (v) => /.+@.+\..+/.test(v) || "L'e-mail doit être valide",
    ],
    password: "",
    passwordRules: [
      (v) => !!v || "Le mot de passe est obligatoire",
      (v) =>
      (v && v.length >= 6) ||
        "Le mot de passe doit comporter 6 caractères ou plus!",
    ],
  }),

  methods: {
    async submitHandler() {
      const response = await axios.post('v1/users/:userId?id=<integer>', {
        email: this.email,
        password: this.password
      });

      console.log(response);
      this.$route.push('/connexion');

      if (this.$refs.form.validate()) {
        this.loading = true;
        setTimeout(() => {
          this.loading = false;
          this.snackbar = true;
        }, 3000);
      }
    },
  },
};
</script>
<style>
.background {
  background-image: url(../assets/logoApp.png) !important;
  height: 100%;
  width: 100%;
  display: block;
  position: absolute;
  top: 0;
  background-size: cover;
  background-position: center;
}
</style>
