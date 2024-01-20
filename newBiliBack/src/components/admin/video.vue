<template>
  <div>
    <div class="barrage" style="width: 70%; float: left">
      <video
          :src="'http://localhost:3307/static/video/' + this.id + '.mp4'"
          autoplay
          controls="controls"
          id="myvideo"
          @timeupdate="videoTimeUpdate()"
          @pause="myPause()"
          @play="myPlay()"
      >
      </video>

      <canvas id="myCanvas">

      </canvas>

      <el-form :inline="true" :model="sendform" ref="SendFormRef">
          <el-form-item prop="comment">
            <el-input @keyup.enter.native="sendDM" v-model="sendform.comment" style="width: 600px;" placeholder="发送弹幕">
                <el-button slot="append" @click="sendDM()">发送</el-button>
            </el-input>
          </el-form-item>
        <el-form-item v-model="sendform.time"></el-form-item>
        <el-form-item v-model="sendform.username"></el-form-item>
        <el-form-item>
          <el-color-picker v-model="sendform.color"></el-color-picker>
        </el-form-item>
      </el-form>
    </div>
    <div style="width: 29%; float: right">
      <el-table
          :data="tableData"
          style="width: 100%">
        <el-table-column
            prop="time"
            label="时间"
            width="80">
        </el-table-column>
        <el-table-column
            prop="comment"
            label="弹幕内容"
            width="280">
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import barrageEffect from "@/components/Barrage";

// const ws = new WebSocket('ws://localhost:8082');
const ws = new WebSocket('ws://localhost:8080');

export default {
  data() {
    return{
      id: "",
      canvasWidth:0,
      canvasHeight:0,
      tableData: [

      ],
      barrage: null,
      sendform: {
        id: "",
        username: "ymzting",
        comment: "",
        time: "0.00",
        color: "#000000",
        isuse: "0"
      },
      lastTime: 0
    }
  },
  methods: {


    handleWsMessage(e){
      console.log("来到这里了")
      this.getDM();
    },
    myPause(){
      this.barrage.clickStop = false;
    },
    myPlay(){
      this.barrage.clickStop = true;
      this.barrage.drawBarrage();
    },
    init(){
      const fonSize = 15;
      const highwayAmount = 4;
      this.barrage = new barrageEffect.Barrage('myCanvas',this.canvasWidth, this.canvasHeight,highwayAmount,fonSize);
    },
    setCanvas(){
      let canvasStyle = document.getElementById('myCanvas')
      this.canvasHeight = canvasStyle.offsetHeight
      this.canvasWidth = canvasStyle.offsetWidth
      this.init();
    },
      getVideoURL(){
        this.id=this.$route.query.video;
      },
    sendDM(){
      this.getVideoTime();
      this.$refs.SendFormRef.validate(async valid => {
        if(!valid) return;
        let {data:res} = await this.$http.post("send", this.sendform);
        if(res === "okk"){
          this.$message.success("发送成功")

          // this.getDM();
          ws.send("1");

        }else {
          this.$message.error("发送失败")
        }
        this.sendform.color="#000000"
      })
    },
    // 获取当前视频时间点赋值给弹幕
    getVideoTime(){
      const video = document.getElementById("myvideo");
      this.sendform.time = video.currentTime;
    },
    // 视频时间发生变化
    videoTimeUpdate(){
      let video = document.getElementById("myvideo");
      this.addTestToBarrage(video.currentTime)
    },
    // 将弹幕列表中弹幕插入发送弹幕列表
    addTestToBarrage(currentTime){
      // 当前时间小于上一次调用该函数的时间
      if(currentTime < this.lastTime){
        this.tableData.forEach((val) => {
          val.isuse = "0";
        })
        this.barrage.barrageList = [];
      }
      this.lastTime = currentTime;
      for(let i = 0; i < this.tableData.length; i++){
        if(parseInt(this.tableData[i].time) === parseInt(currentTime) && this.tableData[i].isuse === "0") {
          this.barrage.addTest(this.tableData[i].comment, this.tableData[i].color);
          this.tableData[i].isuse = "1";
        }
      }
    },
    //
    /**
     * 从接口得到该视频的弹幕信息
     */
    getDM(){
        axios.get("/comment", {
          params:{
            id: this.sendform.id
          }
        })
            .then((res) => {
              this.tableData = res.data;
              console.log(this.tableData)
            })
    }
  },
  created() {
    this.sendform.id=this.$route.query.video;
    this.getVideoURL()
    this.getDM()
  },
  mounted() {
    this.setCanvas();
    ws.addEventListener('message', this.handleWsMessage.bind(this), false);
  },
}
</script>

<style scoped lang="less">
#myvideo {
  width: 85%;
  margin-left: 10%;
}

.barrage{
  width: 100vw;
  height: 80vh;
  position: relative;
  #myCanvas{
    position: absolute;
    z-index: 2;
    width: 85%;
    margin-left: 12.6%;
    top:0px;
    left: 0;
    height: 40%;
  }
}

</style>
