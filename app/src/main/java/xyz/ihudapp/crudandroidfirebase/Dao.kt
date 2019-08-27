package xyz.ihudapp.crudandroidfirebase

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class Dao {

    val database = Firebase.getDatabade()

    fun getByLearn(callback: (ByLearn?)-> Unit){

        database.addValueEventListener(object: ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {
                for (data in p0.children){
                    val byLearn = data.getValue(ByLearn::class.java)
                    callback(byLearn)
                }
            }

        })
    }

    fun salvar(byLearn: ByLearn) {
        database.child("bylearn").setValue(byLearn)
    }
}