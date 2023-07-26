<template>
  <v-container style="margin: 5%; ">
  <h1>Gestion des conteneurs</h1>
  <v-data-table
    :search="search"
    :headers="headers"
    :items="conteneurs"
    :sort-by="[{ key: 'owner', order: 'asc' }]"
    class="elevation-1 text-center"
    border-cell
  >
    <template v-slot:column.owner="{ column }">
      {{ column.title.toUpperCase() }}
    </template>
    <template v-slot:column.name="{ column }">
      {{ column.title.toUpperCase() }}
    </template>
    <template v-slot:column.id="{ column }">
      {{ column.title.toUpperCase() }}
    </template>
    <template v-slot:column.progiciel="{ column }">
      {{ column.title.toUpperCase() }}
    </template>
    <template v-slot:column.date="{ column }">
      {{ column.title.toUpperCase() }}
    </template>
    <template v-slot:column.actions="{ column }">
      {{ column.title.toUpperCase() }}
    </template>
    <template v-slot:top>
      <v-toolbar
        flat
      >
      <v-row>
        <v-col
          cols="12"
          sm="6"
          md="4"
        >
        <v-text-field
          v-model="search"
          label="Rechercher"
          single-line
          hide-details
          variant="underlined"
          class="recherche"
        ></v-text-field>
      </v-col>
    </v-row>
        <v-dialog
          v-model="dialog"
          max-width="500px"
        >
          <template v-slot:activator="{ props }">
            <v-row style="width: max-content; margin-right: -30%;">
            <v-col
              align-self="end" 
            >
            <v-btn
              color="primary"
              dark
              class="mb-2"
              v-bind="props"
            >
              Nouveau
            </v-btn>
            </v-col>
            </v-row>
          </template>
          <v-card width="550px">
            <v-card-title>
              <span class="text-h5">{{ formTitle }}</span>
            </v-card-title>

            <v-card-text>
              <v-container>
                <v-row>
                  <v-col
                    cols="12"
                    sm="6"
                    md="4"
                  >
                    <v-text-field
                      v-model="editedItem.name"
                      label="Nom"
                    ></v-text-field>
                  </v-col>
                  <v-col
                    cols="12"
                    sm="6"
                    md="4"
                  >
                    <v-text-field
                      v-model="editedItem.owner"
                      label="owner"
                    ></v-text-field>
                  </v-col>
                  <v-col
                    cols="12"
                    sm="6"
                    md="4"
                  >
                    <v-text-field
                      v-model="editedItem.id"
                      label="id"
                    ></v-text-field>
                  </v-col>
                  <v-col
                    cols="12"
                    sm="6"
                    md="4"
                  >
                  <v-select
                    v-model="editedItem.progiciel"
                    label="Select"
                    :items="['NUXEO', 'ALFRESCO', 'FILENET']"

                  ></v-select>
                  </v-col>
                  <v-col
                    cols="15"
                    sm="8"
                    md="6"
                  >
                  <v-text-field
                    type="date"
                    v-model="editedItem.date"
                    label="date de création"
                  ></v-text-field>
                  </v-col>
                </v-row>
              </v-container>
            </v-card-text>

            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn
                color="blue-darken-1"
                variant="text"
                @click="close"
              >
                Annuler
              </v-btn>
              <v-btn
                color="blue-darken-1"
                variant="text"
                @click="save"
              >
                Sauvegarder
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
        <v-dialog v-model="dialogDelete" max-width="550px">
          <v-card>
            <v-card-title class="text-h5">Êtes-vous sûr de vouloir supprimer cet élément ?</v-card-title>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue-darken-1" variant="text" @click="closeDelete">Annuler</v-btn>
              <v-btn color="blue-darken-1" variant="text" @click="deleteItemConfirm">OK</v-btn>
              <v-spacer></v-spacer>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-toolbar>
    </template>
    <template v-slot:item.actions="{ item }">
      <v-btn class="ma-3" color="#084772" @click="editItem(item.raw)">
        <p style="color: white; font-size: x-small;">Modifier
          <v-icon  end icon="mdi-pencil"></v-icon>
        </p>
      </v-btn>
      <v-btn class="ma-3" color="#FF6F00" @click="deleteItem(item.raw)">
        <p style="color: white; font-size: x-small;">Supprimer
          <v-icon end icon="mdi-delete"></v-icon>
        </p>
      </v-btn>
    </template>
    <template v-slot:no-data>
      <v-btn
        color="primary"
        @click="initialize"
      >
      Réinitialiser
      </v-btn>
    </template>
  </v-data-table>
</v-container>
</template>



<script>
import { VDataTable } from 'vuetify/labs/VDataTable'


  export default {
    name: "ContainerManagementComponent",
    components:{
      VDataTable,
      
    },
    data: () => ({
      dialog: false,
      dialogDelete: false,
      search: '',
      headers: [
        {
          title: 'Nom du conteneur',
          align: 'start',
          sortable: false,
          key: 'name',
        },
        { title: 'Propriétaire', key: 'owner' },
        { title: 'Id du conteneur', key: 'id' },
        { title: 'Progiciel', key: 'progiciel' },
        { title: 'Date de création', key: 'date' },
        { title: 'Actions', key: 'actions', sortable: false, align: 'center' },
      ],
      conteneurs: [],
      editedIndex: -1,
      editedItem: {
        name: '',
        owner: 0,
        id: 0,
        progiciel: '',
        date: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substring(0, 10),
      },
      defaultItem: {
        name: '',
        owner: 0,
        id: 0,
        progiciel: '',
        date: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substring(0, 10),
      },
      
    }),

    computed: {
      formTitle () {
        return this.editedIndex === -1 ? 'Nouveau conteneur' : 'Editer le conteneur'
      },
      picker: {
        get() {
          return this.value;
        },
        set(val) {
          this.menu = false;
          this.$emit("input", val);
        },
      },
    },

    watch: {
      dialog (val) {
        val || this.close()
      },
      dialogDelete (val) {
        val || this.closeDelete()
      },
    },

    created () {
      this.initialize()
    },

    methods: {
      initialize () {
        this.conteneurs = [
          {
            name: 'Frozen Yogurt',
            owner: 159,
            id: 6.0,
            progiciel: "NUXEO",
            date: 4.0,
          },
          {
            name: 'Ice cream sandwich',
            owner: 237,
            id: 9.0,
            progiciel: "ALFRESCO",
            date: 4.3,
          },
          {
            name: 'Eclair',
            owner: 262,
            id: 16.0,
            progiciel: "FILENET",
            date: 6.0,
          },
          {
            name: 'Cupcake',
            owner: 305,
            id: 3.7,
            progiciel: "NUXEO",
            date: 4.3,
          },
          {
            name: 'Gingerbread',
            owner: 356,
            id: 16.0,
            progiciel: "ALFRESCO",
            date: 3.9,
          },
          {
            name: 'Jelly bean',
            owner: 375,
            id: 0.0,
            progiciel: "NUXEO",
            date: 0.0,
          },
          {
            name: 'Lollipop',
            owner: 392,
            id: 0.2,
            progiciel: "FILENET",
            date: 0,
          },
          {
            name: 'Honeycomb',
            owner: 408,
            id: 3.2,
            progiciel: "NUXEO",
            date: 6.5,
          },
        ]
      },

      editItem (item) {
        this.editedIndex = this.conteneurs.indexOf(item)
        this.editedItem = Object.assign({}, item)
        this.dialog = true
      },

      deleteItem (item) {
        this.editedIndex = this.conteneurs.indexOf(item)
        this.editedItem = Object.assign({}, item)
        this.dialogDelete = true
      },

      deleteItemConfirm () {
        this.conteneurs.splice(this.editedIndex, 1)
        this.closeDelete()
      },

      close () {
        this.dialog = false
        this.$nextTick(() => {
          this.editedItem = Object.assign({}, this.defaultItem)
          this.editedIndex = -1
        })
      },

      closeDelete () {
        this.dialogDelete = false
        this.$nextTick(() => {
          this.editedItem = Object.assign({}, this.defaultItem)
          this.editedIndex = -1
        })
      },

      save () {
        if (this.editedIndex > -1) {
          Object.assign(this.conteneurs[this.editedIndex], this.editedItem)
        } else {
          this.conteneurs.push(this.editedItem)
        }
        this.close()
      },
    },
  }
</script>
<style>
  .recherche{
    margin: 5%;
  }
</style>