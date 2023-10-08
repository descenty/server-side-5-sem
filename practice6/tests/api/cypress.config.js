const { defineConfig } = require("cypress");
require('dotenv').config()

module.exports = defineConfig({
  e2e: {
    setupNodeEvents(on, config) {
    },
    supportFile: false,
    specPattern: "**/*.spec.js",
    baseUrl: process.env.BASE_URL,
    experimentalRunAllSpecs: true,
  },
});
