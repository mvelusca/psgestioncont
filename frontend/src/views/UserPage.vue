<template>
  <v-main>
    <v-container fluid>
      <v-row justify="center">
        <v-col cols="10" md="8">
          <h1 style="margin-bottom: 3%; margin-top: 5%;">Profil d'utilisateur</h1>
          <v-card>
              <v-tabs v-model="tab" grow>
                <v-tab value="editer">Editer votre profil</v-tab>
                <v-tab value="supprimer">Supprimer votre profil</v-tab>
              </v-tabs>
              <v-card-text>
              <v-window v-model="tab">
                <v-window-item value="editer">
                  <v-container>
                    <v-text-field
                      v-model="first"
                      color="primary"
                      label="First name"
                      variant="underlined"
                    ></v-text-field>

                    <v-text-field
                      v-model="last"
                      color="primary"
                      label="Last name"
                      variant="underlined"
                    ></v-text-field>

                    <v-text-field
                      v-model="email"
                      color="primary"
                      label="Email"
                      variant="underlined"
                    ></v-text-field>

                    <v-text-field
                      v-model="password"
                      color="primary"
                      label="Password"
                      placeholder="Enter your password"
                      variant="underlined"
                    ></v-text-field>
                  </v-container>
                  <v-divider></v-divider>
                  <v-card-actions>
                    <v-spacer></v-spacer>

                    <v-btn color="success">
                      Confirmer
                    </v-btn>
                  </v-card-actions>
                </v-window-item>
                <v-window-item value="supprimer">
                  <div class="text-center">
                    <v-dialog
                      v-model="dialog"
                      width="auto"
                    >
                      <template v-slot:activator="{ props }">
                        <v-btn
                          color="primary"
                          v-bind="props"
                        >
                          SUPPRIMER LE PROFIL
                        </v-btn>
                      </template>

                      <v-card>
                        <v-card-text>
                          Vous êtes sur le point de supprimer votre profil.
                          Voulez-vous réellement le supprimer ?
                        </v-card-text>
                        <v-card-actions>
                          <v-btn color="primary" block @click="dialog = false">SUPPRIMER</v-btn>
                        </v-card-actions>
                      </v-card>
                    </v-dialog>
                  </div>
                </v-window-item>
              </v-window>
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </v-main>
</template>

<script>
export default {

  name:"UserPage",

  data: () => ({
    tab: null,
    first: null,
    last: null,
    email: null,
    password: null,
    dialog: false,
  }),

}
</script>

<style>

</style>
