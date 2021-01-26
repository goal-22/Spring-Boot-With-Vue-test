<template>
    <div>
        <el-table :data="tableData">
            <el-table-column prop="id" label="图书编号" width="150">
            </el-table-column>
            <el-table-column prop="name" label="图书名称" width="180">
            </el-table-column>
            <el-table-column prop="author" label="图书作者" width="180">
            </el-table-column>
            <el-table-column prop="publish" label="出版社" width="250">
            </el-table-column>
            <el-table-column prop="price" label="图书价格">
            </el-table-column>
            <el-table-column label="操作" width="250">
                <template slot-scope="scope">
                    <el-button @click="edit(scope.row)" type="text" size="small">编辑</el-button>
                    <el-button @click="deleteBook(scope.row)" type="text" size="small">删除</el-button>
                </template>
            </el-table-column>
        </el-table>

        <el-pagination
                background
                layout="prev, pager, next"
                :total=total align="center"
                :page-size="8"
                @current-change="changePage">
        </el-pagination>

    </div>
</template>

<script>
    const axios = require('axios')

    export default {
        total: '',
        data() {
            return {
                tableData: {
                    id: '',
                    name: '',
                    author: '',
                    publish: '',
                    price: ''
                }
            };
        },
        created() {
            const _this = this;
            axios.get('http://localhost:8181/book/findAll/1/8').then(function (resp) {
                _this.tableData = resp.data.content;
                _this.total = resp.data.totalElements;
            })

        },
        methods: {
            changePage(currentPage) {
                const _this = this;
                axios.get('http://localhost:8181/book/findAll/' + currentPage + '/8').then(function (resp) {
                    _this.tableData = resp.data.content;
                })
            },
            edit(row) {
                this.$router.push({
                    path: '/update',
                    query: {
                        id: row.id,
                        name: row.name,
                        author: row.author,
                        publish: row.publish,
                        price: row.price
                    }
                })
            },

            deleteBook(row) {
                const _this = this;
                this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning',
                }).then(() => {
                    this.$message({
                        type: 'success',
                        message: '删除成功!'
                    });
                    axios.delete('http://localhost:8181/book/deleteById/' + row.id);
                    location.reload();
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });
            }
        }
    }
</script>

<style scoped>

</style>