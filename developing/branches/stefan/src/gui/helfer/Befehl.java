/**
 * 
 */
package gui.helfer;




/**
 * @author andre
 */
public enum Befehl
{
   ELEMENT_ADD,
   ELEMENT_REMOVE,
   ELEMENT_SET_DIAGRAMM,
   ELEMENT_SET_PARENT,
   ELEMENT_SET_PRIORITAET,
   ELEMENT_SET_TITEL,
   ELEMENT_SET_ZUSAMMENFASSUNG,

   //

   USER_ADD,
   USER_REMOVE,
   USER_SET_GRUPPE,
   USER_SET_PASSWORT,

   //

   FILE_LOAD,
   FILE_SAVE,
   FILE_EXIT,
   FILE_ABOUT,
   FILE_NEW,
   FILE_SAVE_AS;


   public String toString()
   {
      switch(this)
      {
         case ELEMENT_ADD :
            return "ELEMENT_ADD";
         case ELEMENT_REMOVE :
            return "ELEMENT_REMOVE";
         case ELEMENT_SET_DIAGRAMM :
            return "ELEMENT_SET_DIAGRAMM";
         case ELEMENT_SET_PARENT :
            return "ELEMENT_SET_PARENT";
         case ELEMENT_SET_PRIORITAET :
            return "ELEMENT_SET_PRIORITAET";
         case ELEMENT_SET_TITEL :
            return "ELEMENT_SET_TITEL";
         case ELEMENT_SET_ZUSAMMENFASSUNG :
            return "ELEMENT_SET_ZUSAMMENFASSUNG";

            //

         case USER_ADD :
            return "USER_ADD";
         case USER_REMOVE :
            return "USER_REMOVE";
         case USER_SET_GRUPPE :
            return "USER_SET_GRUPPE";
         case USER_SET_PASSWORT :
            return "USER_SET_PASSWORT";

            //

         case FILE_LOAD :
            return "FILE_LOAD";
         case FILE_SAVE :
            return "FILE_SAVE";
         case FILE_EXIT :
            return "FILE_EXIT";
         case FILE_ABOUT :
            return "FILE_ABOUT";
         case FILE_NEW :
            return "FILE_NEW";
         case FILE_SAVE_AS :
            return "FILE_SAVE_AS";
         default :
            return "aufzählung enthält hierfür keinen string!";
      }
   }


   public static Befehl toBefehl(String s)
   {
      for(Befehl b : values())
      {
         if(b.toString().equals(s))
            return b;
      }
      return null;
   }
}
