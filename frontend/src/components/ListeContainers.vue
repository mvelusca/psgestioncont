<template>
    <!--Déclaration du tableau-->
    <v-table  height="580px" class="tableau" >
      <!--:key="componentKey"-->
      <thead>
        <tr>
          <th class="text-left" style="color: #084772">Nom du conteneur</th>
          <th class="text-left" style="color: #084772">Créateur</th>
          <th class="text-left" style="color: #084772">Date de création</th>
          <th class="text-left" style="color: #084772">CPU</th>
          <th class="text-left" style="color: #084772">RAM</th>
          <th class="text-left" style="color: #084772">Etat</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in listToDisplay" :key="item.name">
          <td>{{ item.name }}</td>
          <td>{{ item.createur }}</td>
          <td>{{ item.date }}</td>
          <td>{{ item.cpu }}</td>
          <td>{{ item.ram }}</td>
          <td>{{ item.etat }}</td>
          <td>{{ item.activite }}</td>
          <td>
            <v-btn class="ma-2" color="#084772">
    <p style="color: white; font-size: x-small;">Start
      <v-icon end icon="mdi-checkbox-marked-circle"></v-icon>
    </p>
  </v-btn>
</td>
<td>
  <v-btn class="ma-2" color="#FF6F00">
    <p style="color: white; font-size: x-small;">Stop
      <v-icon end icon="mdi-cancel"></v-icon>
    </p>
  </v-btn>
          </td>
        </tr>
      </tbody>
    </v-table>
</template>

<script>
import { mapGetters, mapState } from 'vuex';
//import {ref} from 'vue';
import SideBarComponent from './SideBarComponent.vue';

export default {
  components:{
    SideBarComponent,
  },

  computed: {
    ... mapState(['listGlobal']),
    ... mapGetters(['listGlobal']),

    listToDisplay() {
      const containerSelected = this.$store.state.containerSelected;
      //console.error(containerName);
      if (!containerSelected || containerSelected === '') {
        return this.listGlobal;
      }
      else {
        var newList = [];
        newList.push(containerSelected);
        return newList;

      }
    },
},

watch: {},

};
</script>

<style>
.mx-auto {
  margin-top: 30px;
}

.tableau {
  margin-top: 30px;
  width: 1000px;
  margin-left: 20px;
}

.ma-2 {
  width: 70px;
}
</style>
