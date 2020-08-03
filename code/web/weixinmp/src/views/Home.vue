<template>
  <div class="home">
    <mt-field label="username" placeholder="Input username" v-model="username"></mt-field>
    <mt-field label="email" placeholder="Input email" type="email" v-model="email"></mt-field>
    <mt-field label="password" placeholder="Input password" type="password" v-model="password"></mt-field>
    <mt-field label="phone" placeholder="Input tel" type="tel" v-model="phone"></mt-field>
    <mt-field label="website" placeholder="Input website" type="url" v-model="website"></mt-field>
    <mt-field label="number" placeholder="Input number" type="number" v-model="number"></mt-field>
    <mt-field label="birthday" placeholder="Input birthday" type="date" v-model="birthday"></mt-field>
    <mt-switch v-model="value"></mt-switch>
  </div>
</template>

<script>
export default {
    data() {
        return {
            username: '',
            email: '',
            password: '',
            phone: '',
            website: '',
            number: '',
            birthday: '',
            value: true
        }
    }
}
</script>
