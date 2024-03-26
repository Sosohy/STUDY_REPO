<template>
    <div>
        <h1>Home</h1>
        <h2>currentRoute = {{ currentRoute }}</h2>
    </div>
</template>

<script setup>
import {useRoute} from 'vue-router'

const currentRoute = useRoute();
</script>