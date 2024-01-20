<template>
  <div>
    <el-carousel :interval="4000" type="card" height="400px">
      <el-carousel-item v-for="item in videoList" :key="item.id">
        <router-link :to="'/video?video=' + item.id">
        <img :src=getImgURL(item.id) style="width: 100%; height: 100%">
        </router-link>
      </el-carousel-item>
    </el-carousel>
    <div style="margin-right: 4%">
      <el-col :span="5" v-for="item in videoList" :key="item.id" :offset="1">
        <el-card :body-style="{ padding: '0px' }" shadow="hover">
          <router-link :to="'/video?video=' + item.id">
          <img :src="getImgURL(item.id)" style="width: 100%">
          <p>{{ item.name }}</p>
          </router-link>
        </el-card>
      </el-col>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data(){
    return {
      videoList: [],

    }
  },
  methods: {
    getVideoList(){
      axios.get("/videolist")
          .then((res) => {
            this.videoList = res.data
            console.log(this.videoList)
          })
    },
    getImgURL(imgId){
      return "http://localhost:9000/static/img/" + imgId + ".jpg"
    }
  },
  created() {
    this.getVideoList();
  }
}
</script>

<style scoped lang="less">
// 走马灯样式
/deep/ .el-carousel__button {// 指示器按钮
  width: 10px;
  height: 10px;
  border: none;
  border-radius: 50%;
  background-color: rgba(0, 0, 0, 0.2);
}
/deep/ .is-active .el-carousel__button {// 指示器激活按钮
  background: #3f8ec8;
}
</style>
