import { createWebHistory, createRouter } from "vue-router";


const routes = [
    {
      path: "/",
      name: "Board List",
      component: () => import('@/pages/BoardList.vue'),
    },
    
  ];
  
  const router = createRouter({
    history: createWebHistory(),
    routes,
  });
  
  export default router;