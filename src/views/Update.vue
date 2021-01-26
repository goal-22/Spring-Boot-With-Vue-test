<template>
    <div>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="105px" class="demo-ruleForm">
            <el-form-item label="图书编号" prop="id">
                <el-input v-model="ruleForm.id" readonly></el-input>
            </el-form-item>
            <el-form-item label="图书名称" prop="name">
                <el-input v-model="ruleForm.name"></el-input>
            </el-form-item>
            <el-form-item label="图书作者" prop="author">
                <el-input v-model="ruleForm.author"></el-input>
            </el-form-item>
            <el-form-item label="出版社" prop="publish">
                <el-input v-model="ruleForm.publish"></el-input>
            </el-form-item>
            <el-form-item label="图书价格(元)" prop="price">
                <el-input v-model="ruleForm.price"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    const axios = require('axios')
    export default {
        data() {
            return {
                ruleForm: {
                    id: '',
                    name: '',
                    author: '',
                    publish: '',
                    price:''
                },
                rules: {
                    name: [
                        {required: true, message: '请输入图书名称', trigger: 'blur'}
                    ],
                    author: [
                        {required: true, message: '请输入作者名称', trigger: 'blur'}
                    ],
                    publish: [
                        {required: true, message: '请输入出版社', trigger: 'blur'}
                    ],
                    price: [
                        {required: true, message: '请输入图书价格', trigger: 'blur'}
                    ]
                }
            };
        },
        created() {
            this.ruleForm.id = this.$route.query.id;
            this.ruleForm.name = this.$route.query.name;
            this.ruleForm.author = this.$route.query.author;
            this.ruleForm.publish = this.$route.query.publish;
            this.ruleForm.price = this.$route.query.price;
        },
        methods: {
            submitForm(formName) {
                const _this = this;
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        axios.put("http://localhost:8181/book/update",this.ruleForm).then(function (resp) {
                            if (resp.data == "success"){
                                _this.success();
                                _this.$router.push("/find")
                            } else {
                                _this.error();
                            }
                        })
                    } else {
                        alert("error submit")
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            success() {
                this.$message({
                    message: '修改成功',
                    type: 'success'
                });
            },
            error(){
                this.$message.error('修改失败');
            }
        }
    }
</script>

<style scoped>
    .demo-ruleForm{
        margin-left: 25%;
        margin-right: 40%;
    }
</style>