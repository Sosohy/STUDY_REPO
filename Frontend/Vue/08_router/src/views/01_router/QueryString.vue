<template>
    <div>
        <h1>queryString</h1>
        <h2>currentRoute query = {{ currentRoute.query }}</h2>
        <h2>currentRoute name = {{ currentRoute.query.name }}</h2>
        <h2>currentRoute age = {{ currentRoute.query.age }}</h2>
    </div>
</template>

<script setup>
import {useRoute} from 'vue-router'

const currentRoute = useRoute();
</script>

<style scoped></style>