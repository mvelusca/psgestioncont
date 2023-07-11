<template>
  <v-main>
    <v-container fluid>
      <v-row justify="center">
        <v-col cols="10" md="8">
          <h1 style="margin-bottom: 3%; margin-top: 5%;">Gestion des utilisateurs</h1>
          <v-card>

              <v-tabs v-model="tab" grow>
                <v-tab value="ajouter">Ajouter</v-tab>
                <v-tab value="supprimer">Supprimer</v-tab>
                <v-tab value="editer">Éditer</v-tab>
              </v-tabs>

              <v-window v-model="tab">
                <v-window-item value="ajouter">
                  <v-expansion-panels>
                    <v-expansion-panel title="Notification d'ajout" text="Aucune notification(s)">
                    </v-expansion-panel>
                    <v-expansion-panel title="Ajout manuel">
                      <v-expansion-panel-text>
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

                        <v-text-field
                          v-model="role"
                          color="primary"
                          label="Role"
                          placeholder="user/admin"
                          variant="underlined"
                        ></v-text-field>

                      <v-divider></v-divider>
                      <v-card-actions>
                        <v-spacer></v-spacer>

                        <v-btn color="success">
                          Confirmer
                        </v-btn>
                      </v-card-actions>
                    </v-expansion-panel-text>
                    </v-expansion-panel>
                  </v-expansion-panels>
                </v-window-item>

                <v-window-item value="supprimer">
                  <v-expansion-panels>
                    <v-expansion-panel title="Rechercher l'utilisateur à supprimer">
                      <v-expansion-panel-text>
                        <v-card-text>
                          <v-text-field
                            :loading="loading"
                            density="compact"
                            variant="solo"
                            label="Rechercher"
                            append-inner-icon="mdi-magnify"
                            single-line
                            hide-details
                            @click:append-inner="onClick"
                          ></v-text-field>
                        </v-card-text>
                      </v-expansion-panel-text>
                    </v-expansion-panel>
                      <v-expansion-panel title="Supprimer plusieurs">
                      <v-expansion-panel-text>
                      </v-expansion-panel-text>
                    </v-expansion-panel>
                  </v-expansion-panels>
                </v-window-item>

                <v-window-item value="editer">
                  <v-expansion-panels>
                    <v-expansion-panel title="Rechercher l'utilisateur à éditer">
                      <v-expansion-panel-text>
                        <v-card-text>
                          <v-text-field
                            :loading="loading"
                            density="compact"
                            variant="solo"
                            label="Rechercher"
                            append-inner-icon="mdi-magnify"
                            single-line
                            hide-details
                            @click:append-inner="onClick"
                          ></v-text-field>
                        </v-card-text>
                      </v-expansion-panel-text>
                    </v-expansion-panel>
                      <v-expansion-panel title="Éditer plusieurs">
                      <v-expansion-panel-text>
                      </v-expansion-panel-text>
                    </v-expansion-panel>
                  </v-expansion-panels>
                </v-window-item>

              </v-window>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </v-main>


</template>

<script>
export default {
  name: "UserManagementComponent",

  data: () => ({
    tab: null,
    loaded: false,
    loading: false,
  }),

  methods: {
    onClick () {
      this.loading = true

      setTimeout(() => {
        this.loading = false
        this.loaded = true
      }, 2000)
    },
  },

}
</script>

<style>

</style>
