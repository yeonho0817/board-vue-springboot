<template>
  <PageHeader />
  <div class="content-wrapper">
    <router-view />
  </div>
  <PageFooter />
</template>

<script setup lang="ts">
import PageHeader from '@/components/PageHeader.vue'
import PageFooter from '@/components/PageFooter.vue'

</script>

<style>

</style>
