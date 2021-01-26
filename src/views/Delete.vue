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
            <el-table-column prop="price" label="图书价格" width="250">
            </el-table-column>
            <el-table-column
                    fixed="right"
                    label="操作">
                <template slot-scope="scope">
                    <el-button @click="handleClick(scope.row.id)" type="text" size="small">删除</el-button>
                    <el-button type="text" size="small">修改</el-button>
                </template>
            </el-table-column>
        </el-table>

    </div>
</template>

<script>
    export default {
        methods: {
            handleClick(row) {
                alert(row)
            }
        },
            data() {
                const item = {
                    id: '1',
                    name: '百科全书',
                    author: 'Davis',
                    publish: '中国人民出版社',
                    price: '49.00'
                };
                return {
                    tableData: Array(20).fill(item)
                };
            }
    }
</script>