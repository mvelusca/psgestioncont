<template>
  <v-main>
    <v-container fluid>
      <v-row justify="center">
        <v-col cols="10" md="8">
          <h1 style="margin-bottom: 3%; margin-top: 5%;">Gestion des conteneurs</h1>
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
                        <v-row>
                <v-col
                  cols="12"
                  md="4"
                >
                  <v-text-field
                    label="Company (disabled)"
                    disabled
                  />
                </v-col>

                <v-col
                  cols="12"
                  md="4"
                >
                  <v-text-field
                    class="purple-input"
                    v-model="name"
                    label="Nom du conteneur"
                    variant="underlined"
                  />
                </v-col>

                <v-col
                  cols="12"
                  md="4"
                >
                  <v-text-field
                    label="numero de port"
                    v-model="port"
                    class="purple-input"
                    variant="underlined"
                  />
                </v-col>

                <v-col
                  cols="12"
                  md="6"
                >
                  <v-text-field
                    label="First Name"
                    class="purple-input"
                    variant="underlined"
                  />
                </v-col>

                <v-col
                  cols="12"
                  md="6"
                >
                  <v-text-field
                    label="Last Name"
                    class="purple-input"
                    variant="underlined"
                  />
                </v-col>

                <v-col cols="12">
                  <v-text-field
                    label="Adress"
                    class="purple-input"
                    variant="underlined"
                  />
                </v-col>

                <v-col
                  cols="12"
                  md="4"
                >
                  <v-text-field
                    label="City"
                    class="purple-input"
                    variant="underlined"
                  />
                </v-col>

                <v-col
                  cols="12"
                  md="4"
                >
                  <v-text-field
                    label="Country"
                    class="purple-input"
                    variant="underlined"
                  />
                </v-col>

                <v-col
                  cols="12"
                  md="4"
                >
                  <v-text-field
                    class="purple-input"
                    label="Postal Code"
                    type="number"
                    variant="underlined"
                  />
                </v-col>
              </v-row>
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
                    <v-expansion-panel title="Rechercher le conteneur à supprimer">
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
                    <v-expansion-panel title="Rechercher le conteneur à éditer">
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
  name: "ContainerManagementComponent",

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
