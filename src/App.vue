<template>
    <div>

        <el-container style="height: 55px">
            <el-header style="text-align: center; font-size: 45px; font-family: 'PingFang SC'">
                图书管理系统
            </el-header>
        </el-container>

        <el-container style="height: 650px; border: 1px solid #eee">

            <el-aside width="202px">
                <el-radio-group v-model="isCollapse" style="margin-bottom: 20px;">
                    <el-radio-button :label="false">展开</el-radio-button>
                    <el-radio-button :label="true">收起</el-radio-button>
                </el-radio-group>
                <el-menu default-active="1" class="el-menu-vertical-demo" router @open="handleOpen" @close="handleClose"
                         :collapse="isCollapse">
                    <el-menu-item index="/find">
                        <i class="el-icon-search"></i>
                        <span slot="title">查询</span>
                    </el-menu-item>
                    <el-menu-item index="/add">
                        <i class="el-icon-plus"></i>
                        <span slot="title">添加</span>
                    </el-menu-item>
                </el-menu>

            </el-aside>

            <el-main>
                <router-view>
                </router-view>
            </el-main>

        </el-container>

    </div>
</template>

<style>

    .el-menu-vertical-demo:not(.el-menu--collapse) {
        width: 200px;
        min-height: 400px;
    }


</style>

<script>
    export default {

        data() {
            const item = {
                id: '1',
                name: '百科全书',
                author: 'Davis',
                publish: '中国人民出版社',
                price: '49.00'
            };
            return {
                isCollapse: true,
                tableData: Array(20).fill(item)
            };
        },
        methods: {
            handleOpen(key, keyPath) {
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, keyPath);
            }
        }
    };

</script>
