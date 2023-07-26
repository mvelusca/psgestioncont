<template>
<v-app>
    <div class="background"></div>
    <v-main class="d-flex justify-center align-center">
      <v-col cols="10" lg="4" class="mx-auto">
        <v-card class="pa-4">
          <div class="text-center">
            <v-avatar size="100" color="indigo lighten-4">
              <v-icon size="40" color="white">mdi-account</v-icon>
            </v-avatar>
          </div>

    <v-sheet width="300" class="mx-auto">
      <v-form fast-fail @submit.prevent="submitHandler" ref="form">
        <v-text-field
          v-model="nom"
          label="Nom"
          :rules="nomRules"
          prepend-inner-icon="mdi-account"
        ></v-text-field>

        <v-text-field
          v-model="prenom"
          label="Prénom"
          :rules="prenomRules"
          prepend-inner-icon="mdi-account"
        ></v-text-field>

        <v-text-field
          v-model="mail"
          label="Adresse mail"
          :rules="mailRules"
          prepend-inner-icon="mdi-at"
        ></v-text-field>

        <v-text-field
          v-model="password"
          label="Mot de passe"
          :rules="passwordRules"
          :type="passwordShow ? 'text' : 'password'"
          prepend-inner-icon="mdi-key"
          :append-icon="passwordShow ? 'mdi-eye' : 'mdi-eye-off'"
          @click:append="passwordShow = !passwordShow"
        ></v-text-field>



        <v-card-actions class="justify-center">
              <v-btn :loading="loading" type="submit" color="primary">
              <span class="white--text px-8">Envoyer la demande</span>
              </v-btn>      
        </v-card-actions>

      </v-form>
    </v-sheet>

        </v-card>
      </v-col>
    </v-main>
</v-app>
</template>



<script>
import axios from 'axios'
  export default {
    data: () => ({
      nom: '',
      nomRules: [
        value => {
          if (value?.length > 1) return true

          return 'Le nom doit faire au moins 1 caractère.'
        },
      ],
      prenom: '',
      prenomRules: [
        value => {
          if (/[^0-9]/.test(value)) return true

          return 'Le prénom ne doit pas contenir des chiffres'
        },
      ],
      mail: '',
      mailRules: [
        value => {
            if (value && value.endsWith('@amexio.fr')) {
                return true;
            }
            return 'Veuillez utiliser l\'adresse mail d\'Amexio.'
        },
      ],
      password: '',
      passwordShow: false,
      passwordRules: [
      (v) => !!v || "Le mot de passe est obligatoire",
      (v) =>
        (v && v.length >= 6) ||
        "Le mot de passe doit comporter 6 caractères ou plus!",
      (v) =>
        (v && /[a-z]/.test(v) && /[A-Z]/.test(v)) ||
        "Le mot de passe doit comporter au moins une majuscule et une miniscule!",
    ],
    }),

    methods:{
      async submitHandler(){
        const response = await axios.post('v1/users', {
          nom : this.nom,
          prenom : this.prenom,
          unite: this.unite,
          mail : this.mail,
          password : this.password
        });

        console.log(response)
      }
    }

  }
</script>
