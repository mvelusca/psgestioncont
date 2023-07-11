<template>
  <v-main>
  <v-container style="margin-top: 5%;">
    <div>
      <h1>Tableau de bord</h1>
      <v-select
        class="selectContainer"
        label="Selectionner un conteneur"
        :items="['Conteneur 1', 'Conteneur 2', 'Conteneur 3', 'Conteneur 4', 'Conteneur 5']"
      ></v-select>
    </div>
    <v-row >
      <div class="d-flex justify-start">
      <v-col>
        <v-sheet class="conteneur" width="500" elevation="4" :height="200">
          <v-card-title style="color:#FF6F00 ;">Conteneurs</v-card-title>
          <v-row style="height: 150px;">
            <v-col >
              <p>Total</p>
              <p>10</p>
            </v-col>

              <v-divider vertical length="130px" style="margin-top: 2%;"></v-divider>

            <v-col>
              <p>Actifs</p>
              <p>5</p>
            </v-col>
          </v-row>

        </v-sheet>
      </v-col>
      </div>
      <div class="d-flex justify-end">
      <v-col>
        <v-sheet class="stockage" width="500" elevation="4" :height="200">
          <v-card-title style="color:#FF6F00 ;">Stockage</v-card-title>
          <v-row style="height: 150px;">
            <v-col >
              <p>Total</p>
              <p>2 To</p>
            </v-col>

              <v-divider vertical length="130px" style="margin-top: 2%;"></v-divider>

            <v-col>
              <p>Utilisés</p>
              <p>150 Go</p>
            </v-col>
          </v-row>
        </v-sheet>
      </v-col>
      </div>
    </v-row>

    <v-row no-gutters>

      <v-col>
        <v-sheet class="globale" width="1025" elevation="4">
          <v-card-title style="color:#FF6F00 ;">Utilisation globale</v-card-title>
          <v-divider></v-divider>
          <v-row>
            <v-col>
              <v-sheet class="cpu" width="500" :height="300" style="margin-top: 5%;">
                <div>
                  <v-card-subtitle style="color:#FF6F00; margin-left: 2%;">
                    CPU
                  </v-card-subtitle>
                </div>
                <v-divider class="border-opacity-50" :thickness="2" style="width: 80%; margin-left: 5%;"></v-divider>

                <v-progress-circular
                  color="#084772"
                  :rotate="360"
                  :model-value="value"
                  :size="100"
                  :width="7"
                  style="margin-top: 15%; margin-left: 32%;"
                >{{ value }}%</v-progress-circular>
                <v-divider class="border-opacity-50" :thickness="2" style="width: 80%; margin-left: 5%; margin-top: 10%;"></v-divider>
              </v-sheet>
            </v-col>
            <v-col>
              <v-sheet class="cpu" width="500" :height="300" style="margin-top: 5%;">
                <div>
                  <v-card-subtitle style="color:#FF6F00 ; margin-left: 2%;">
                    RAM
                  </v-card-subtitle>
                </div>
                <v-divider class="border-opacity-50" :thickness="2" style="width: 80%; margin-left: 5%;"></v-divider>

                <v-progress-circular
                  color="#084772"
                  :rotate="360"
                  :model-value="value"
                  :size="100"
                  :width="7"
                  style="margin-top: 15%; margin-left: 32%;"
                >{{ value }}Go</v-progress-circular>
                <v-divider class="border-opacity-50" :thickness="2" style="width: 80%; margin-left: 5%; margin-top: 10%;"></v-divider>
              </v-sheet>
            </v-col>
          </v-row>
        </v-sheet>
      </v-col>

    </v-row>
  </v-container>
</v-main>
</template>

  <script>
  import { defineComponent } from "vue";

  // Components


  export default defineComponent({
    name: "DashboardComponent",

    components: {

    },

    data () {
      return {
        interval: {},
        value: 0,
      }
    },
    beforeUnmount () {
      clearInterval(this.interval)
    },
    mounted () {
      this.interval = setInterval(() => {
        if (this.value === 100) {
          return (this.value = 0)
        }
        this.value += 10
      }, 1000)
    },

  });
  </script>
<style scoped>
.selectContainer{
  width: 30%;

}
.conteneur {
  margin-top: 10%;
  text-align: center;
}

.stockage{
  margin-top: 10%;
  /*margin-left: -10%;*/
  text-align: center;
}

.globale{
  margin-top: 5%;
}

.v-progress-circular {
  margin: 1rem;
}

</style>
