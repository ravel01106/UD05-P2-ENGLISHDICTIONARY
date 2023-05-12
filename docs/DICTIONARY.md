# <div align="center">**DICTIONARY CLASS**</div>

<br>

# **Definition:**

- In this class, has been created **one attribute** which it is a map. In it, the key is **the character or initial** of the words and the value is a **set's collection** which it has **all words that have the same initial**.
  <br><br>

# **Methods:**

- ## **addWord**

  This method **add word inside the dictionary** passing as parameter a word.

  If the dictionary **contains the initial of the word**, will be added inside the set's collection. **If not**, will be created a new key that it will be the character of the word and The word will be added inside the set's collection. It is worth mentioning that a message will be sent **indicating that the word has been successfully added**.

  Beside, it will be checked if it **is empty** or only **contains blank spaces**.

  <br><br>

- ## **deleteWord**

  This method **delete word** of the dictionary passing as parameter a word.

  If the dictionary **contains the initial of the word**, will be deleted of the set's collection and a message will be sent saying that the word has been successfully removed. **If not**, a message will be sent saying that the word was not found in the dictionary.

  Beside, it will be checked if it **is empty** or only **contains blank spaces**.

  <br><br>

- ## **existWord**

  This method **checks that the word**, which it is passed as a parameter, **it is in the dictionary**.

  If **the method find it**, a message will be sent indicating that the word exists in the dictionary. **If not**, a message will be sent indicating that the word doesn't exist in it.

  Beside, it will be checked if it **is empty** or only **contains blank spaces**.

  <br><br>

- ## **showInitialAvailable**

  This method shows **how many initials there are available**.

  <br><br>

- ## **showWordsWithInitial**

  This method show a list the word that they start with the initial which it is passed as a parameter.
  If the dictionary **contains the initial of the character**, a message will be sent showing a list of words that start with this initial. **If not**, a message will be sent indicating that the character doesn't exist in it.

  Beside, it will be checked if it **is empty** or only **contains blank spaces**.
  <br><br>

If you want to return, [click here](../README.md).
