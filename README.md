# clj-test-task

Assuming a large (> 2GB) dictionary of passwords (one per line), write a dictionary-attacker in Clojure.

You can use any built-in Java-9/Clojure-1.10/Linux facilities to solve the problem, but no external libraries.

If you can describe a high-level approach that should work, but are not quite sure of how to put the code together, that's perfectly acceptable too.

The top-level/public API should be just this function below. For the sake of simplicity, put all your code in a single namespace.
(defn dictionary-attack [try-fn ...] ....)

Its first argument (`try-fn` predicate), you don't need to write, as its sole purpose is to return true/false (match or no-match).

## Usage

```shell
lein run dict-file [out-file]
```

## License

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
