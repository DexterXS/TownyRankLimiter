```markdown
# TownyRankLimiter

TownyRankLimiter is a Minecraft plugin designed to limit the number of certain ranks that can be assigned in a Towny town. This plugin ensures that the maximum number of specific ranks is not exceeded.

## Features

- Limits the number of specific ranks in a Towny town.
- Configuration file for setting maximum numbers of each rank.
- Command to reload the configuration without restarting the server.
- Multilingual support with configurable messages.
- Color support in messages using `&` for color codes.

## Installation

1. Download the latest release of TownyRankLimiter.
2. Place the TownyRankLimiter.jar file into your server's `plugins` directory.
3. Start your server to generate the default configuration file.
4. Configure the ranks and limits in the `config.yml` file located in the `plugins/TownyRankLimiter` directory.
5. Use `/t rank reload` to reload the configuration without restarting the server.

## Configuration

Example `config.yml`:
```yaml
ranks:
  Deputy: 3
  Policeman: 10
  Judge: 2

messages:
  rank_limit_exceeded: "&cThe maximum number of rank {rank} has been exceeded, the maximum is: {limit}."
  reload_success: "&aConfiguration reloaded successfully."
  no_permission: "&cYou do not have permission to execute this command."
```

## Commands

- `/t rank reload`: Reloads the plugin configuration.

## Permissions

- `townyranklimiter.reload`: Allows the user to reload the plugin configuration. (Default: OP)

## Building from Source

1. Clone the repository:
   ```sh
   git clone https://github.com/DexterXS/TownyRankLimiter.git
   cd TownyRankLimiter
   ```

2. Build the project using Maven:
   ```sh
   mvn clean package
   ```

3. The compiled JAR file will be located in the `target` directory.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request.

## Contact

For support or inquiries, please contact [your-email@example.com].
```

### `LICENSE`

```plaintext
MIT License

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
