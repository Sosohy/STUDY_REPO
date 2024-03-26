import {createRouter, createWebHashHistory, createWebHistory} from 'vue-router';

import HomeView from '@/views/01_router/HomeView.vue';
import PathVariable from '@/views/01_router/PathVariable.vue';
import QueryString from '@/views/01_router/QueryString.vue';


const router = createRouter({   // 라우터 객체 생성
    // history: createWebHashHistory(),
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            component: HomeView
        },
        {
            path: '/pathvariable/:id',
            component: PathVariable
        },
        {
            path: '/querystring',
            component: QueryString
        }
    ]
});

/* router 객체를 export(main.js에서 import할 용도) */
export default router;