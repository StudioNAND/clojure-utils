# NAND Clojure Tools

Frequently needed helpers for working with Clojure

[![Clojars Project](https://img.shields.io/clojars/v/io.nand/utils.svg)](https://clojars.org/io.nand/utils)

## Usage locally for dev/testing

See leiningen’s
[own docs](https://github.com/technomancy/leiningen/blob/stable/doc/TUTORIAL.md#checkout-dependencies)
for more info on how to checkout local dependencies

### Install
1. Clone repo
2. run `lein install` to install the lib locally and allow lein to
   find it (needs to be done with every version bump)
   
### Use in other projects locally
3. add a folder `checkouts` to the root of your project
4. inside `checkouts` create a symlink to the nand-clj folder:
   ```
   cd into ./checkouts
   ln -s path-to/nand-clj nand-clj
   ```
5. then start your repl
