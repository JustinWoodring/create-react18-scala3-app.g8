const path = require("path");
const CopyWebpackPlugin = require('copy-webpack-plugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
  mode: "development",
  resolve: {
    alias: {
      "resources": path.resolve(__dirname, "../../../../src/main/resources"),
      "js": path.resolve(__dirname, "../../../../src/main/js"),
      "scalajs": path.resolve(__dirname, "./scalajs-entry.js")
    },
    modules: [ path.resolve(__dirname, 'node_modules') ]
  },
  module: {
    rules: [
      {
        test: /\.css\$/,
        use: [ 'style-loader', 'css-loader' ]
      },
      // "file" loader for svg
      {
        test: /\.svg\$/,
        use: [
          {
            loader: 'file-loader',
            ident: 'static/media/[name].[hash:8].[ext]'
          }
        ]
      }
    ]
  },
  plugins: [
    new CopyWebpackPlugin({
      patterns: [
        {
          from: path.resolve(__dirname, "../../../../public"),
          globOptions: {
            ignore: [
              "**/index.html"
            ]
          }
        }
      ]
    }),
    new HtmlWebpackPlugin({
      template: path.resolve(__dirname, "../../../../public/index.html")
    })
  ],
  output: {
    devtoolModuleFilenameTemplate: (f) => {
      if (f.resourcePath.startsWith("http://") ||
          f.resourcePath.startsWith("https://") ||
          f.resourcePath.startsWith("file://")) {
        return f.resourcePath;
      } else {
        return "webpack://" + f.namespace + "/" + f.resourcePath;
      }
    }
  }
}
