<template>
  <div>
    <el-container>
      <el-header>
        <el-menu
            :default-active="activeIndex"
            class="el-menu-demo"
            mode="horizontal"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b"
            :router="true">
          <el-menu-item index="/home">首页</el-menu-item>
          <el-submenu index="2">
            <template slot="title">分类</template>
            <el-menu-item index="2-1">选项1</el-menu-item>
            <el-menu-item index="2-2">选项2</el-menu-item>
            <el-menu-item index="2-3">选项3</el-menu-item>
            <el-submenu index="2-4">
              <template slot="title">选项4</template>
              <el-menu-item index="2-4-1">选项1</el-menu-item>
              <el-menu-item index="2-4-2">选项2</el-menu-item>
              <el-menu-item index="2-4-3">选项3</el-menu-item>
            </el-submenu>
          </el-submenu>
          <el-menu-item index="" class="searchInput">
            <el-input @keyup.enter.native="mySearch()" placeholder="请输入您想看的视频">
              <el-button slot="append" @click="mySearch()">搜索</el-button>
            </el-input>
          </el-menu-item>
        </el-menu>
      </el-header>

      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </div>
</template>

<script>
export default {
  data(){
    return{
      activeIndex: "/home",
    }
  },
  methods:{
    mySearch(){
      console.log("您已经点击了")
    }
  }
}
</script>

<style scoped lang="less">
.el-header {
  background-color: #545c64;
  color: #333;
  text-align: center;
  line-height: 60px;
}
.el-main {
  background-color: #E9EEF3;
  color: #333;
  text-align: center;
  //line-height: 160px;
  background-color: white;
  min-width: 1280px;
}
.searchInput {
  width: 36%;
}
</style>
