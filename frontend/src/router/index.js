import { createRouter, createWebHistory } from "vue-router";
import LoginPage from "@/views/LoginPage.vue";
import HomePage from "@/views/HomePage.vue";
import ContainersPage from "@/views/ContainersPage.vue";
import ConnexionPage from "@/views/ConnexionPage.vue";
import Test from "@/views/Test.vue";
import DashboardComponent from "@/components/DashboardComponent.vue";
import UserPage from "@/views/UserPage.vue";
import UserManagementComponent from "@/components/UserManagementComponent.vue"
import ContainerManagementComponent from "@/components/ContainerManagementComponent.vue"


const routes = [
  {
    path: "/",
    name: "login",
    component: LoginPage,
  },
  {
    path: "/home",
    name: "home",
    component: HomePage,
  },
  {
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  },
  {
    path: "/containers",
    name: "containers",
    component: ContainersPage,
  },
  {
    path: "/",
    name: "login",
    component: LoginPage,
  },

  {
    path: "/dashboard",
    name: "dashboard",
    component: DashboardComponent
  },
  {
    path: "/userProfile",
    name: "userProfile",
    component: UserPage
  },

  {
    path: "/connexion",
    name: "connexion",
    component: ConnexionPage,
  },

  {
    path: "/test",
    name: "test",
    component: Test,
  },

  {
    path: "/administration/usermanagement",
    name: "usermanagement",
    component: UserManagementComponent,
  },

  {
    path: "/administration/containermanagement",
    name: "containermanagement",
    component: ContainerManagementComponent,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;