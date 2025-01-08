import java.util.Scanner

class NotesMenu (
    classMenuItems: MutableList<String>,
    typeList: MutableList<Notes>
) : MenuNavigation<Notes>(classMenuItems, typeList) {
    override fun createType(typeName: String, typeList: MutableList<Notes>) {
        val notes = Notes(typeName)
        while (true) {
            println("Введите текст заметки")
            val notesText = Scanner(System.`in`).nextLine()
            val trimedText = notesText.trim()
            if (trimedText != "") {
                notes.text = notesText
                typeList.add(notes)
                break
            } else {
                println("Текст заметки не может быть пустым")
                continue
            }
        }
    }

    override fun handleSelection(userSelection: Int, typeList: MutableList<Notes>) {
        val selectedName = typeList.get(userSelection).notesName
        println("$selectedName")
        val notesText = typeList.get(userSelection).text
        println("$notesText")


    }
    override fun printList(typeList: MutableList<Notes>) {
        for(i in typeList.indices) {
            println("${i}: ${typeList[i].notesName}")
        }
    }
}