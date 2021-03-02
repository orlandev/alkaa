package com.escodro.repository

import com.escodro.domain.model.Category
import com.escodro.domain.repository.CategoryRepository
import com.escodro.repository.datasource.CategoryDataSource
import com.escodro.repository.mapper.CategoryMapper
import javax.inject.Inject

internal class CategoryRepositoryImpl @Inject constructor(
    private val categoryDataSource: CategoryDataSource,
    private val categoryMapper: CategoryMapper
) : CategoryRepository {

    override suspend fun insertCategory(category: Category) =
        categoryDataSource.insertCategory(categoryMapper.toRepo(category))

    override suspend fun insertCategory(categoryList: List<Category>) =
        categoryDataSource.insertCategory(categoryMapper.toRepo(categoryList))

    override suspend fun updateCategory(category: Category) =
        categoryDataSource.updateCategory(categoryMapper.toRepo(category))

    override suspend fun deleteCategory(category: Category) =
        categoryDataSource.deleteCategory(categoryMapper.toRepo(category))

    override suspend fun cleanTable() =
        categoryDataSource.cleanTable()

    override suspend fun findAllCategories(): List<Category> =
        categoryDataSource.findAllCategories().map { categoryMapper.toDomain(it) }

    override suspend fun findCategoryById(categoryId: Long): Category? =
        categoryDataSource.findCategoryById(categoryId)?.let { categoryMapper.toDomain(it) }
}
