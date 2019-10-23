# eegutils-win

EEG tools for Windows.

Version History and Release Notes:

1.0: Original version in Schwanke's computer.

1.1: Output changed to .asc which is tab separated instead of comma separate values.

1.2: Option for 118 and 300 epochs (A or B). Now prints program version before execution.

1.3: Select Paradigm <Type> = { EG | P1 | N4 | P3 } from the command line.

1.3.1: Fixed bug prefix naming of dataset2.

1.3.2: P1 and only P1 will change the frequency to 128 samples per epoch instead of 256.

1.3.3: Small Refactor to the code (Code is now being developed on windows). And now you can
       invoke the program with small case letters: eg | p1 | n4 | p3 because users were typing
       it with lowercase.

1.3.4: Added P5 based on P3.

1.3.5: Added P51 which is a variant of P5 with different number of epochs.

