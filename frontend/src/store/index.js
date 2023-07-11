import { createStore } from 'vuex'

export default createStore({
  state: {
    drawer: null,
    containerSelected: null,
    listAlfresco: [
      {
        name: "Contenair Alfresco 1",
        createur: "pierre",
        cpu: "55",
        ram: "44",
        date: "22/11/23",
        etat: "Actif",
      },
      {
        name: "Contenair Alfresco 2",
        createur: "pierre",
        cpu: "55",
        ram: "44",
        date: "22/11/23",
        etat: "Actif"
      },
    ],
    listFileNet: [
      {
        name: "Contenair FileNet 1",
        createur: "pierre",
        cpu: "55",
        ram: "44",
        date: "22/11/23",
        etat: "Actif"
      },
      {
        name: "Contenair FileNet 2",
        createur: "pierre",
        cpu: "55",
        ram: "44",
        date: "22/11/23",
        etat: "Actif"
      },
    ],
      listNuxeo: [
      {
        name: "Contenair Nuxeo 1",
        createur: "pierre",
        cpu: "55",
        ram: "44",
        date: "22/11/23",
        etat: "Actif"
      },
      {
        name: "Contenair Nuxeo 2",
        createur: "pierre",
        cpu: "55",
        ram: "44",
        date: "22/11/23",
        etat: "Actif"
      },
    ]
  },
  
  getters: {
      getContainer: state => {
        return `$(state.containerSelected)`
      }, 
      getList: state => {
        return `$(state.listAlfresco)-$(state.listFileNet)-$(state.listNuxeo)`
      },
      getListGlobal: state => {
        //listGlobal =  listAlfresco + listFileNet + listNuxeo;
        listGlobal  = listAlfresco.concat(listFileNet);
        console.log(listGlobal);
        return `$(state.listGlobal)`
      },
  },
  
  mutations: {
    SET_DRAWER (state, payload) {
      state.drawer = payload;
    },
    SET_CONTAINER_SELECTED(state, payload) {
      state.containerSelected = payload;
      console.log(state.containerSelected)
    },
  },
  actions: {

  },
  modules: {
  }
})
