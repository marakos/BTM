Υλοποιήθηκε ένα αρκετά σημαντικό κομμάτι του UI μαζί με ικανοποιητική λειτουργικότητα. 

-Η κλάση TrainingScheduleGenerator δεν υλοποιήθηκε.

-Στην κλάση TeamMembership δεν υλοποιήθηκε η ανακατεύθυνση σε εξωτερικό σύστημα πληρωμής, εμφανίζεται αντίστοιχο μήνυμα παρόλα αυτά. Επιπλέον, δεν είναι λειτουργική η κλάση, αφού δεν έχει γίνει σύνδεση με τις υπόλοιπες λειτουργίες, ούτε επίσης κατοχυρώνεται στον χρήστη η αντίστοιχη άδεια χρήσης που έχει επιλέξει.

-Η κλάση SetTeamStandards δημιουργεί αντικείμενο team_standard, κάθε φορά που ο χρήστης εισάγει όλα τα δεδομένα στην εφαρμογή και επιλέγει να αποθηκεύσει το standard, και το αποθηκεύει σε αρχείο. Η παρουσίαση των αποθηκευμένων δεδομένων δεν έχει υλοποιηθεί όπως επίσης δεν έχουν υλοποιηθεί έλεγχοι εγκυρότητας των δεδομένων. 

-Στην κλάση PlayerGameAnalysis φορτώνεται preloaded video και υπάρχουν οι δυνατότητες video player, παρόλα αυτά δεν είναι λειτουργική αφού δεν έχει υλοποιηθεί τόσο η εξαγωγή στιγμιότυπων όσο και η συνένωση αυτών.

-Η κλάση ManagePlayersInformation δημιουργεί αντικείμενο player_info κάθε φορά που ο χρήστης εισάγει στην εφαρμογή όλα τα χαρακτηριστικά του παίκτη. Παρόλα αυτά, δεν έχει υλοποιηθεί έλεγχος εγκυρότητας δεδομένων και η παρουσίαση των αποθηκευμένων παικτών.

-Η κλάση ManageExercise δημιουργεί αντικείμενο training_exercise και το αποθηκεύει σε αρχείο. Υλοποιήθηκε αρχείο συστήματος category.txt το οποίο περιέχει κατηγορίες ασκήσεων, ώστε ο χρήστης να μπορεί να επιλέξει την κατηγορία κάθε άσκησης, πριν την αποθήκευση. Στα Import video και save video, εμφανίζονται αντίστοιχα μηνύματα όμως δεν είναι λειτουργικά.

-Στην κλάση GameAnalysis φορτώνεται preloaded video και υπάρχουν όλες οι δυνατότητες video player, παρόλα αυτά δεν είναι λειτουργική αφού δεν υποστηρίζει την σχεδίαση σε πίνακα και αποθήκευση.

-Η κλάση ManageTeamSchedule δημιουργεί αντικείμενο match, με την ημερομηνία και την δυσκολία του παιχνιδιού και το αποθηκεύει σε αρχείο. Κατά την επιλογή των app settings, εμφανίζεται αντίστοιχο μήνυμα. Δημιουργείται, τέλος, αντικείμενο day off το οποίο αποθηκεύεται στο αντίστοιχο αρχείο.  Τέλος, στην παρουσίαση των αποθηκευμένων δεδομένων, εμφανίζονται οι πιο σημαντικές ημερομηνίες.

-Στην κλάση ManageTeamMembers, ο χρήστης εισάγει ένα όνομα χρήστη και το σύστημα το εντοπίζει στο αντίστοιχο αρχείο. Αν δεν υπάρχει το όνομα στο αρχείο, εμφανίζει μήνυμα σφάλματος.  Σε περίπτωση που δεν επιλεγεί ρόλος, εμφανίζει μήνυμα σφάλματος . Όταν γίνει η προσθήκη του μέλους στην άδεια, εμφανίζει τα σχετικά αρχεία. Για τη διαγραφή κάποιου μέλους από την άδεια επιλέγεται η αντίστοιχη γραμμή και εμφανίζεται μήνυμα διαγραφής.

-Στην κλάση MatchStatistics ο χρήστης επιλέγει παίκτη από αρχείο(δεν έχει γίνει σύνδεση με την κλάση ManagePlayersInformation), εισάγει τα στατιστικά του παίκτη και δημιουργεί αντικείμενο match_stats για τον επιλεγμένο παίκτη. Δεν έχει υλοποιηθεί η σύνδεση με τον αντίστοιχο αγώνα. Στην εξαγωγή, εμφανίζεται αντίστοιχο μήνυμα χωρίς να αρχίζει διαδικασία λήψης.

-Στην κλάση TrainingStatistics επιλέγεται προπονητική άσκηση και παίκτης από αντίστοιχα αρχεία, εισάγεται τιμή για την εκτέλεση της άσκησης(χωρίς έλεγχο) και δημιουργείται αντικείμενο  training_info και το αποθηκεύει σε αρχείο. Στην εξαγωγή, εμφανίζεται αντίστοιχο μήνυμα χωρίς να αρχίζει διαδικασία λήψης.

-Στην κλάση TrainingImpact επιλέγεται χρονικό διάστημα, παίκτης και εμφανίζονται τα στατιστικά του παίκτη(δεν έχει υλοποιηθεί η σύνδεση με Match Statistics). Κατά την επιλογή εμφάνισης των διαγραμμάτων, εμφανίζεται μήνυμα επιτυχίας και δημιουργείται αντικείμενο chart χωρίς να παρουσιάζεται σε διάγραμμα. Στην εξαγωγή, εμφανίζεται αντίστοιχο μήνυμα χωρίς να αρχίζει διαδικασία λήψης.


Δεν έχει υλοποιηθεί διαχείριση της εφαρμογής σε επίπεδο χρηστών. Η κατασκευή της εφαρμογής έγινε με την λογική να δημιουργηθούν ανεξάρτητα κομμάτια κώδικα και όχι σαν σύνολο εφαρμογής. Σε καμία από τις κλάσεις λειτουργιών δεν έχει υλοποιηθεί η εξαγωγή αρχείου προς λήψη και η τροποποίηση-διαγραφή αποθηκευμένων δεδομένων, όπως το τελευταίο είχε αναφερθεί σε προηγούμενα παραδοτέα. Επίσης οι παραπάνω κλάσεις, περιέχουν μεθόδους που δεν έχουν υλοποιηθεί στο class diagram, μιας και σχετίζονται με το interface και όχι με το backend κομμάτι της εφαρμογής. Δεν υπάρχουν στο class diagram μέθοδοι που σχετίζονται με την αποθήκευση object σε file αφού ουσιαστικά στην πραγματική υλοποίηση της εφαρμογής, τα δεδομένα αποθηκεύονται σε βάση δεδομένων.
