import { createWebHistory, createRouter, useRoute } from "vue-router";
import { useRouter } from 'vue-router';

const route = useRouter();


const routes = [
    {
      path: "/",
      name: "Board List",
      component: () => import('@/pages/BoardList.vue'),
    },
    {
      path: "/detail",
      name: "Board Detail",
      component: () => import('@/pages/BoardDetail.vue'),
      props: (route: { query: any; }) => ({ query: route.query }),
    },
  ];
  
  const router = createRouter({
    history: createWebHistory(),
    routes,
  });
  
  export default router;