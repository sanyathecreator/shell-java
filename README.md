# Shell-Java

A Unix-like shell implementation in Java.

## About

This project is a functional command-line shell that mimics the behavior of popular Unix shells like bash and zsh. It demonstrates core shell functionality including command parsing, process execution, I/O redirection, and more.

## Features

### Core Features

- **REPL (Read-Eval-Print Loop)**: Interactive command-line interface
- **External Command Execution**: Run any executable found in PATH
- **PATH Resolution**: Automatic lookup of executables in system PATH directories
- **Error Handling**: Graceful handling of invalid commands and missing executables

### Builtin Commands

- [x] `exit [code]` - Exit the shell with optional exit code
- [x] `echo <text>` - Display text to standard output
- [x] `pwd` - Print working directory
- [x] `cd <path>` - Change directory (supports `~` for home directory, `.` and `..`)
- [x] `type <command>` - Display whether a command is builtin or external

### Advanced Features Progress

#### Input Parsing & Quoting
- [ ] Single quote handling (`'text'`)
- [ ] Double quote handling (`"text"`)
- [ ] Escape sequences (`\n`, `\t`, etc.)
- [ ] Variable expansion (`$VAR`, `${VAR}`)
- [x] Basic whitespace splitting

#### I/O Redirection
- [ ] Output redirection (`>`)
- [ ] Output append (`>>`)
- [ ] Error redirection (`2>`)
- [ ] Error append (`2>>`)
- [ ] Combined output redirection (`1>`, `1>>`)
- [ ] Input redirection (`<`)

#### Pipeline Support
- [ ] Basic piping (`command1 | command2`)
- [ ] Multi-stage pipelines (`cmd1 | cmd2 | cmd3`)
- [ ] Builtin commands in pipelines
- [ ] Pipeline error handling

#### History Management
- [ ] Command history tracking
- [ ] `history` command - Display command history
- [ ] `history N` - Display last N commands
- [ ] `history -r <file>` - Read history from file
- [ ] `history -w <file>` - Write history to file
- [ ] `history -a <file>` - Append history to file
- [ ] History persistence across sessions

#### Interactive Features
- [ ] Tab completion for commands
- [ ] Tab completion for file paths
- [ ] Command history navigation (up/down arrows)
- [ ] Line editing support
- [ ] Syntax highlighting

#### Additional Shell Features
- [ ] Background process execution (`&`)
- [ ] Job control (`fg`, `bg`, `jobs`)
- [ ] Signal handling (Ctrl+C, Ctrl+Z)
- [ ] Environment variable management
- [ ] Alias support
- [ ] Script execution mode

## Architecture

The codebase follows a clean, modular architecture:

```
com.sanyathecreator.shell/
├── Main.java                    # Entry point
├── core/
│   ├── Shell.java              # Main REPL implementation
│   └── ShellContext.java       # Shared shell state (working directory, etc.)
├── command/
│   ├── Command.java            # Command interface
│   ├── CommandRegistry.java   # Builtin command registry
│   ├── EchoCommand.java        # Echo implementation
│   ├── ExitCommand.java        # Exit implementation
│   ├── PwdCommand.java         # Pwd implementation
│   ├── CdCommand.java          # Cd implementation
│   ├── TypeCommand.java        # Type implementation
│   └── ExternalCommand.java   # External command executor
└── util/
    ├── InputParser.java        # Input parsing utilities
    └── PathResolver.java       # PATH lookup utilities
```

## Building & Running

### Prerequisites
- Java 11 or higher
- Gradle 7.x or higher

### Build
```bash
./gradlew build
```

### Run
```bash
java Main.java
# or
./gradlew run
```

### Create Distribution
```bash
./gradlew installDist
./app/build/install/app/bin/app
```

## Usage Examples

```bash
# Basic commands
$ echo Hello, World!
Hello, World!

$ pwd
/home/user/workspace/shell-java

$ cd /tmp
$ pwd
/tmp

# Home directory navigation
$ cd ~
$ pwd
/home/user

# Relative paths
$ cd workspace/shell-java
$ pwd
/home/user/workspace/shell-java

# Command type checking
$ type echo
echo is a shell builtin

$ type ls
ls is /usr/bin/ls

$ type nonexistent
nonexistent: not found

# External commands
$ ls
app  build.gradle.kts  README.md  settings.gradle.kts

$ cat README.md
[content of README.md]
```

**Current Status**: ~30% complete
- Core shell functionality: Complete
- Builtin commands: Complete
- Advanced features (I/O, pipelines, history): To be implemented

## Contributing

This is a learning project, but suggestions and improvements are welcome! Feel free to:
- Open issues for bugs or feature requests
- Submit pull requests with enhancements
- Share feedback on code structure and design

## Resources

- [CodeCrafters Shell Challenge](https://codecrafters.io/challenges/shell)
- [Bash Reference Manual](https://www.gnu.org/software/bash/manual/bash.html)

## License

This project is created for educational purposes as part of the CodeCrafters challenge.

## Author

Built with determination by [@sanyathecreator](https://github.com/sanyathecreator)
