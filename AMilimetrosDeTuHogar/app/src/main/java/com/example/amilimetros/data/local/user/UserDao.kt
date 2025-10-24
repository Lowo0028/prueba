package com.example.amilimetros.data.local.user

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {

    // ========== INSERTAR ==========
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(user: UserEntity): Long

    // ========== ACTUALIZAR ==========
    @Update
    suspend fun update(user: UserEntity)

    // ========== ELIMINAR ==========
    @Delete
    suspend fun delete(user: UserEntity)

    // ========== OBTENER POR EMAIL ==========
    @Query("SELECT * FROM users WHERE email = :email LIMIT 1")
    suspend fun getByEmail(email: String): UserEntity?

    // ========== OBTENER POR ID ==========
    @Query("SELECT * FROM users WHERE id = :id LIMIT 1")
    suspend fun getById(id: Long): UserEntity?

    // ========== CONTAR USUARIOS ==========
    @Query("SELECT COUNT(*) FROM users")
    suspend fun count(): Int

    // ========== OBTENER TODOS ==========
    @Query("SELECT * FROM users ORDER BY id ASC")
    suspend fun getAll(): List<UserEntity>

    // ========== VERIFICAR SI EXISTE EMAIL ==========
    @Query("SELECT EXISTS(SELECT 1 FROM users WHERE email = :email)")
    suspend fun emailExists(email: String): Boolean

    // ========== OBTENER ADMINISTRADORES ==========
    @Query("SELECT * FROM users WHERE isAdmin = 1")
    suspend fun getAllAdmins(): List<UserEntity>
}